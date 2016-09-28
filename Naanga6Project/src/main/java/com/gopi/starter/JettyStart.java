package com.gopi.starter;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
/**
 * 
 * @author gopi
 *
 */
public class JettyStart extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static List<String> startName=new ArrayList<String>();
	private static List <Map<String,Object>> result;
	private static int  i=0;
	
	public static  void redirectWeb(List <Map<String,Object>> ouput) throws Exception {
		result=ouput;
		Server server = new Server(7070);
		ServletContextHandler handler = new ServletContextHandler(server, "/Naanga6Calculation");
		handler.addServlet(JettyStart.class, "/");
		server.start();
		 try  {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI("http://localhost:7070/Naanga6Calculation/");
			  desktop.browse(oURL);
			  synchronized(server)  {
				  System.out.println("ENTERING INTO WAIT METHOD ");
					 server.wait(100000);
				 }
			} catch (Exception e) {
			  e.printStackTrace();
			}
		
		server.stop();
		System.out.println("SERVER HAS BEEN STOPPED DUE TO LONG RUNNING");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int j = 0;
		while(j<5){
			resp.getWriter().println();
			j++;
		}

		resp.setStatus(HttpStatus.OK_200);
		resp.getWriter().println("                                                                           NAANGA 6 PROJECT");
		//System.out.println("result :"+result);
		for(Map<String,Object> map:result){
			if(i==0){
				resp.getWriter().println("                                                      ----  ------------------------------  ----------  -----------");
				resp.getWriter().println("                                                      S_NO  NAME                            AMOUNT      CALC_DATE");
				i++;
			}
			String name=((String) map.get("NAME")).substring(0, 4);
			if(!startName.contains(name) ){
				startName.clear();
				resp.getWriter().println("                                                      ----  ------------------------------  ----------  -----------");
			startName.add(name);
			}
			
			for(String Key:map.keySet()){
				if(Key.equals("S_NO"))
					resp.getWriter().print("                                                     ");
				resp.getWriter().print(" "+map.get(Key)+" ");
				
			}
			resp.getWriter().println();
			
		}
		resp.getWriter().println("                                                      ----  ------------------------------  ----------  -----------");
		resp.getWriter().print("                                                      @Copyright© 2016 Gopi & Chandru for Naanga4Project");
		i=0;
		startName.clear();
		
	}
	
}
