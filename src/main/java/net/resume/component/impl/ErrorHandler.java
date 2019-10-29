package net.resume.component.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.resume.filter.AbstractFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//перехватывает все ошибки , даже спринговые благодаря реализации спрингового интерфейса HandlerExceptionResolver и производит их логгирование и обработку
@Component
public class ErrorHandler extends AbstractFilter implements HandlerExceptionResolver {

	@Value("${application.production}")
	private boolean production;

	//обрабатывает спринговые ошибки
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		} else {
			throw new IllegalArgumentException(ex);
		}
	}
	//фильтр для обработки ошибок ( фильтр верхнего уровня )
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		String requestUrl = req.getRequestURI();
		try {
			chain.doFilter(req, resp);
		} catch (Throwable th) {
			LOGGER.error("Process request failed: " + requestUrl, th);
			handleException(th, requestUrl, resp);
		}
	}

	//выполняет перенаправление на страницу ошибки
	protected void handleException(Throwable th, String requestUrl, HttpServletResponse resp) throws ServletException, IOException {
		if (production) {
			if (requestUrl.startsWith("/fragment") || "/error".equals(requestUrl)) {
				sendErrorStatus(resp);
			} else {
				resp.sendRedirect("/error?url=" + requestUrl);
			}
		} else {
			throw new ServletException(th);
		}
	}

	//отсылает код ошибки при ошибке в ajax запросе
	protected void sendErrorStatus(HttpServletResponse resp) throws IOException {
		resp.reset();
		resp.getWriter().write("");
		resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
}
