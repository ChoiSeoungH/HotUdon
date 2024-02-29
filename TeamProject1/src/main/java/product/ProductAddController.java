package product;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import dao.AuctionDAO;
import dao.ProductDAO;
import dao.ProductImgDAO;
import frontcontorller.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Auction;
import vo.Product;
import vo.ProductImg;

public class ProductAddController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("productName")==(null)) {
			return "product/productAdd";
		}
		 String saveDirectory = request.getServletContext().getRealPath("/img");
		dao.UtilDAO.newFolder(request);
		ArrayList <String> images = dao.UtilDAO.multipleFile(request, saveDirectory);
		String image = String.join(",", images);
		
		String title =request.getParameter("productName");
		int sellerNo = Integer.parseInt(request.getParameter("no"));
		int price =Integer.parseInt(request.getParameter("productPrice"));
		int method = Integer.parseInt(request.getParameter("method"));
		int is_auction = Integer.parseInt(request.getParameter("is_auction"));
		int category = Integer.parseInt(request.getParameter("category"));
		String productContent = request.getParameter("productContent");
		System.out.println(image);
		


		if(is_auction == 0 ) { // 경매 방법
			Product vo = new Product(0, category, sellerNo, title, price, productContent,null, false, null, method,0,null); 
			ProductDAO.getInstance().insertOneProduct(vo);
			int no =ProductDAO.getInstance().getselectAucton();
			ProductImg Img = new ProductImg(no, image, null);
			ProductImgDAO.getInstance().addOneProductImg(Img);
			return "main";
		
		}else { 
			// 경매일떄  일단
			Product vo = new Product(0, category, sellerNo, title, price, productContent,null, true, null, method,0,null); 
			ProductDAO.getInstance().insertOneProduct(vo);
			int no =ProductDAO.getInstance().getselectAucton();
			Auction au = new Auction(no, price, null, 0);
			ProductImg Img = new ProductImg(no, image, null);
			ProductImgDAO.getInstance().addOneProductImg(Img);
			AuctionDAO.getInstance().addAuction(au);
			return "main";
			
		}

	}

}