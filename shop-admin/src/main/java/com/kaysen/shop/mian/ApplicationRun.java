package com.kaysen.shop.mian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Classname ApplicationRun
 * @Description TODO
 * @Date 2019/7/29 15:46
 * @Created by ks.xu
 */
@SpringBootApplication
//@EnableWebMvc
@ComponentScan(basePackages = "com.kaysen.shop.*")
@MapperScan({"com.kaysen.shop.web.**.dao"})
public class ApplicationRun {
    public static void main(String args[]){
        System.out.println("                                                                                                                                                 ");
        System.out.println("          *****                                          *****                                           ****                                    ");
        System.out.println("          **                   ****                      ***                  ****                       **                  ****                ");
        System.out.println("        ** ***                     ***                 **  *                       **                  ** *                       **             ");
        System.out.println("       **             **              **              **          *       **         **              **          *       **         **           ");
        System.out.println("      **         *    **   **          *              *      **   **      *     *     *             ***     **   **      **    *     **          ");
        System.out.println("  ***           **    **      **       **         **                 ***              **         **                 ***              ***         ");
        System.out.println("  ***          *      **        *      **         **          ****         ****       **         **          ****          ****      ***         ");
        System.out.println("  *****      **       **      *        ********   ****                                ********   ****                                *********   ");
        System.out.println("      *                     *          *****    *     *            **        **       ******  **    **            **         *       ******   ** ");
        System.out.println("      *                  **            *              *            **        **       *             **            **         *       **          ");
        System.out.println("       **          ***                **              **           **  *****          *              **           **  *****          *           ");
        System.out.println("        **  ***                      **                **          **               **                 **         **               **            ");
        System.out.println("          **  ******************   **                    ***  *****************   **                     **  ******************  **              ");
        System.out.println("           *****                 *                         ****                 **                         ***                 **                ");
        System.out.println("                                                                                                                                                 ");
//        System.out.println("                               _(\\_/) ");
//        System.out.println("                             ,((((^`\\");
//        System.out.println("                             ((((  (6 \\ ");
//        System.out.println("                          ,((((( ,    \\");
//        System.out.println("       ,,,_              ,(((((  /*._  ,`,");
//        System.out.println("      ((((\\\\ ,...       ,((((   /    `-.-'");
//        System.out.println("      )))  ;'    `*'*'**((((   (      ");
//        System.out.println("    (((  /            (((      \\");
//        System.out.println("      )) |                      |");
//        System.out.println("     ((  |        .       '     |");
//        System.out.println("     ))  \\     _ '      `t   ,.')");
//        System.out.println("     (   |   y;- -,-**'*-.\\   \\/  ");
//        System.out.println("    )   / ./  ) /         `\\  \\");
//        System.out.println("        |./   ( (           / /'");
//        System.out.println("        ||     \\\\          //'|");
//        System.out.println("        ||      \\\\       _//'||");
//        System.out.println("        ||       ))     |_/  ||");
//        System.out.println("        \\_\\     |_/          ||");
//        System.out.println("                             \\_\\");
//        System.out.println("                             `'*");
        SpringApplication springApplication = new SpringApplication(ApplicationRun.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
