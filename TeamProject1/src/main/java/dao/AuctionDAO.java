package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MybatisConfig;
import vo.Auction;

public class AuctionDAO {
	private AuctionDAO() {
	}
	private static AuctionDAO instance = new AuctionDAO();
	
	public static AuctionDAO getInstance() {
			return instance;
	}
	
//	경매추가일시
	public List<Auction> addAuction(Auction vo){
		SqlSession session = MybatisConfig.getInstance().openSession();
		List<Auction> list = session.selectList("mapper.product.addOneAuction",vo);
		session.commit();
		session.close();
		return list;
	}
	
	
}