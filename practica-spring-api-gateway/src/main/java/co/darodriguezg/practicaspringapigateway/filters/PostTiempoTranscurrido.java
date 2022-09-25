package co.darodriguezg.practicaspringapigateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PostTiempoTranscurrido extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostTiempoTranscurrido.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("Entrando a Post filter");

        Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
        Long tiempoFinal = System.currentTimeMillis();
        LOGGER.info(String.format("Tiempo transcurrido: %s milisegundos, %s segundos", tiempoFinal - tiempoInicio, (tiempoFinal - tiempoInicio)/1000.00));
        return null;
    }
}
