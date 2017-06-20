package test;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by wangqiang on 2017/6/15.
 */
@WebService
@Path("/test")
public class TestWebServiceImpl implements TestWebService{
    @GET
    @Path("/testE")
    @Produces("application/json;charset=UTF-8")
    public String testE() {

        return "tttttttttt";
    }
}
