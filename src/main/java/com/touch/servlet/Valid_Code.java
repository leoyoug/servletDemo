package com.touch.servlet;
import javax.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Valid_Code extends HttpServlet {
    private int width=100;
    private int height=30;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g= img.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(1,1,width-1,height-1);
        g.setColor(Color.RED);
        g.drawRect(0,0,width-1,height-1);
        g.setFont(new Font("黑体",Font.ITALIC|Font.BOLD,15));
        Random random=new Random();
        int position=0;
        String code="";
        for(int x=0;x<4;x++){
            int i=random.nextInt(10);
            g.drawString(Integer.toString(i),position,15);
            position=position+28;
            code=code+i;
        }
        HttpSession session=req.getSession();
        session.setAttribute("code",code);

        try {
            ImageIO.write(img,"jpg",resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
