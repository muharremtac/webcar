package com.muharremtac.arduino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final String ARDUINO_IP = "192.168.1.44";
	private static final int ARDUINO_PORT = 23;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	static Socket pingSocket = null;
	static PrintWriter out = null;
    static BufferedReader in = null;
    
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/ajax", method = RequestMethod.GET)
	public String getWifi(HttpServletRequest request, Model model) {
		try {
			String method = request.getParameter("methot");
			sendTelnet(method);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return "home";
	}
	
	public static void main(String[] args) {
		try {
			sendTelnet("d");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	public static void sendTelnet(String method) throws IOException {
        try {
            if(pingSocket!=null && pingSocket.isConnected()) {
            	sendTelnetData(method);
            }else{
            	pingSocket = new Socket(ARDUINO_IP, ARDUINO_PORT);
                sendTelnetData(method);
            }
        } catch (IOException e) {
            if(out!=null)
            	out.close();
            if(in!=null)
            	in.close();
            if(pingSocket!=null && pingSocket.isConnected())
            	pingSocket.close();
			logger.error(e.getMessage());
        }

    }

	private static void sendTelnetData(String method) throws IOException {
		out = new PrintWriter(pingSocket.getOutputStream(), true);
		out.println(method);
	}
	
}
