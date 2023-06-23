
package sv.edu.formas.s7.servicios;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;


public class OtroServicioCliente {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/S5Servicios/webapi/";

    public OtroServicioCliente() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cliente");
    }


    public <T> T agregarCliente(Class<T> responseType, String nom, String apellido) throws ClientErrorException {
        String[] formParamNames = new String[]{"nom", "apellido"};
        String[] formParamValues = new String[]{nom, apellido};
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(javax.ws.rs.client.Entity.form(getQueryOrFormParams(formParamNames, formParamValues)), responseType);
    }

    /**
     * @param responseType Class representing the response
     * @return response object (instance of responseType class)@param authorization header parameter[REQUIRED]
     */
    public <T> T consultarTodos(Class<T> responseType, String authorization) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("Authorization", authorization).get(responseType);
    }

    private Form getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        Form form = new javax.ws.rs.core.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                form = form.param(paramNames[i], paramValues[i]);
            }
        }
        return form;
    }

    public void close() {
        client.close();
    }

    public final void setUsernamePassword(String username, String password) {
        //webTarget.register(new org.glassfish.jersey.client.filter.HttpBasicAuthFilter(username, password));
    }
    
}
