package iflve.com.test;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by admin on 2016/4/4.
 */

public class LoginService implements ISoapService  {

    private static final String NameSpace = "http://tempuri.org/";
    //private static final String URL = "http://www.iflve.com/Service1.svc?wsdl";
    private static final String URL = "http://www.iflve.com/LoginService.svc?wsdl";
    private static final String SOAP_ACTION = "http://tempuri.org/ILoginService/Login";
    private static final String MethodName = "Login";
    private String username;
    private String password;
    public LoginService(String username,String password) {
        this.password = password;
        this.username = username;
    }

    @Override
    public SoapObject LoadResult() {
        SoapObject soapObject = new SoapObject(NameSpace, MethodName);
        soapObject.addProperty("us", username);
        soapObject.addProperty("ps", password);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11); // 版本
        envelope.bodyOut = soapObject;
        envelope.dotNet = true;
        envelope.setOutputSoapObject(soapObject);
        HttpTransportSE trans = new HttpTransportSE(URL);
        trans.debug = true; // 使用调试功能

        try {
            trans.call(SOAP_ACTION, envelope);
            //System.out.println("Call Successful!");
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            System.out.println("XmlPullParserException");
            e.printStackTrace();
        }
        SoapObject result = (SoapObject) envelope.bodyIn;
       // SoapObject result = (SoapObject) envelope.getResponse();
        return result;
    }
}
