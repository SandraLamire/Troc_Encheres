package fr.eni.enchere.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.dal.jdbc.ArticleDAO;
import fr.eni.enchere.dal.jdbc.AuctionDAO;
import fr.eni.enchere.dal.jdbc.CategoryDAO;
import fr.eni.enchere.dal.jdbc.DAOFactory;
import fr.eni.enchere.dal.jdbc.UserDAO;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletTestDAL
 */
@WebServlet("/ServletTestDAL")
public class ServletTestDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestDAL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Déclaration et instanciation des différentes DAO
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
		AuctionDAO auctionDAO = DAOFactory.getAuctionDAO();
		UserDAO userDAO = DAOFactory.getUserDAO();
		CategoryDAO categoryDAO = DAOFactory.getCategoryDAO();

		// Déclaration et instanciation de POJO
		User alexandra = new User("Masque_Panda", "Boulay", "Alexandra", "alex.boulay@orange.fr", "07-85-66-90-96",
				"rue de la foret", "53540", "LAUBRIERES", "quiqui35", 1000, false);
		User luca = new User("Iromega", "Dupont", "Luca", "leboss@gmail.com", "02 90 66 55 22", "rue du pendu", "35500",
				"VITRE", "bidon25", 250, false);
		User alban = new User("Ferach", "Ferrera", "Alban", "banban.ferach@orange.fr", "06 52 33 29 52",
				"rue des perdus", "85600", "AMIENS", "leclown", 3000, true);

		Auction auction1 = new Auction(LocalDate.of(2023, 02, 23), 200, 1, 2);
		Auction auction2 = new Auction(LocalDate.of(2023, 03, 11), 100, 1, 5);
		Auction auction3 = new Auction(LocalDate.of(2023, 02, 01), 50, 2, 4);
		Auction auction4 = new Auction(LocalDate.of(2023, 01, 26), 1000, 2, 3);
		Auction auction5 = new Auction(LocalDate.of(2023, 01, 22), 10, 3, 1);

		Withdrawal withdrawal = new Withdrawal(1, "rue de la foret", "53540", "LAUBRIERES");
		Withdrawal withdrawa2 = new Withdrawal(2, "rue du pendu", "35500", "VITRE");
		Withdrawal withdrawa3 = new Withdrawal(3, "rue des perdus", "85600", "AMIENS");
		Withdrawal withdrawa4 = new Withdrawal(4, "rue de la foret", "53540", "LAUBRIERES");
		Withdrawal withdrawa5 = new Withdrawal(5, "rue de la foret", "53540", "LAUBRIERES");

		Article pcGamer = new Article("PC Gamer 3000", "Un super PC fixe avec de grosses performances",
				LocalDate.of(2023, 01, 20), LocalDate.of(2023, 02, 01), 1, 1, withdrawal);
		Article table = new Article("Table Ronde", "Une table ronde qui fait un mêtre de haut",
				LocalDate.of(2023, 02, 20), LocalDate.of(2023, 02, 25), 2, 2, withdrawa2);
		Article ballon = new Article("Ballon de foot", "Ballon de l'équipe de france signé par tous les joueurs",
				LocalDate.of(2023, 01, 25), LocalDate.of(2023, 02, 03), 3, 4, withdrawa3);
		Article slip = new Article("Slip sale", "Un slip avec une grosse trace de pneu", LocalDate.of(2023, 01, 29),
				LocalDate.of(2023, 03, 02), 1, 3, withdrawa4);
		Article souris = new Article("Souris sans fil", "Une souris sans fil (Connection Bluetooth)",
				LocalDate.of(2023, 03, 10), LocalDate.of(2023, 03, 12), 2, 1, withdrawa5);

		try {
			// =======================================================================================================================================

			// METHODES INSERT
			// Test de la méthode insert de userDAO
			userDAO.insert(alexandra);
			userDAO.insert(luca);
			userDAO.insert(alban);
			// Test avec erreur

			// Test de la méthode insert de articleDAO
			articleDAO.insert(pcGamer);
			articleDAO.insert(table);
			articleDAO.insert(ballon);
			articleDAO.insert(slip);
			articleDAO.insert(souris);
			// Test avec erreur

			// Test de la méthode insert de auctionDAO
			auctionDAO.insert(auction1);
			auctionDAO.insert(auction2);
			auctionDAO.insert(auction3);
			auctionDAO.insert(auction4);
			auctionDAO.insert(auction5);
			// Test avec erreur

			// =======================================================================================================================================
			System.out.println(
					"============================================================================================");
			// METHODES SELECTALL
			// Test de la méthode selectall de userDAO
			List<User> userList = userDAO.selectAll();

			for (User user : userList) {
				System.out.println(user);
			}

			// Test de la méthode selectall de articleDAO
			List<Article> articleList = articleDAO.selectAll();

			for (Article article : articleList) {
				System.out.println(article);
			}

			// Test de la méthode selectall de auctionDAO
			List<Auction> auctionList = auctionDAO.selectAll();

			for (Auction auction : auctionList) {
				System.out.println(auction);
			}

			// =======================================================================================================================================

			// METHODES UPDATE
			// Test de la méthode update de userDAO
			alexandra = new User("BB_Panda", "Boulay", "Alexandra", "alex.boulay@orange.fr", "07-85-66-90-96",
					"rue de la foret", "53540", "LAUBRIERES", "quiqui35", 1000, false);
			userDAO.update(alexandra);
			// Test avec erreur

			// Test de la méthode update de articleDAO
			pcGamer = new Article("PC Gamer cassé", "Un super PC fixe avec de grosses performances",
					LocalDate.of(2023, 01, 20), LocalDate.of(2023, 02, 01), 1, 1, withdrawal);
			articleDAO.update(pcGamer);
			// Test avec erreur

			// Test de la méthode update de auctionDAO
			auction1 = new Auction(LocalDate.of(2023, 02, 23), 500, 1, 2);
			auctionDAO.update(auction1);
			// Test avec erreur

			// =======================================================================================================================================
			System.out.println(
					"============================================================================================");
			// METHDES SELECTBYID
			// Test de la méthode selectbyid de userDAO
			User user = userDAO.selectById(1);
			System.out.println(user);
			// Test avec erreur

			// Test de la méthode selectbyid de articleDAO
			Article article = articleDAO.selectById(1);
			System.out.println(article);
			// Test avec erreur

			// Test de la méthode selectbyid de auctionDAO
			Auction auction = auctionDAO.selectById(1);
			System.out.println(auction);
			// Test avec erreur

			// =======================================================================================================================================

			// METHODES DELETE
			// Test de la méthode delete de userDAO
			userDAO.delete(3);
			// Test avec erreur

			// Test de la méthode delete de articleDAO
			articleDAO.delete(1);
			// Test avec erreur

			// Test de la méthode delete de auctionDAO
			auctionDAO.delete(1);
			// Test avec erreur

			// =======================================================================================================================================

			// METHODE SELECTBYPSEUDOMDP USER
			User userConnexion = userDAO.selectByPseudoMdp("Iromega", "bidon25");
			System.out.println(
					"============================================================================================");
			System.out.println(userConnexion);
			// =======================================================================================================================================

			// METHODE SELECTBYNOCATEGORY ARTICLE
			// Test de la méthode selectByNoCategory de articleDAO
			List<Article> articleListByNoCategory = articleDAO.selectByNoCategory(1);
			System.out.println(
					"============================================================================================");
			for (Article article2 : articleListByNoCategory) {
				System.out.println(article2);
			}
			// Test avec erreur

			// =======================================================================================================================================

			// METHODE SELECTBYCHARNAME ARTICLE
			// Test de la méthode selectByCharName de articleDAO
			List<Article> articleListCharName = articleDAO.selectByCharName("PC");
			System.out.println(
					"============================================================================================");
			for (Article article3 : articleListCharName) {
				System.out.println(article3);
			}
			// Test avec erreur

			// =======================================================================================================================================

			// METHODE SELECTBYCHARNAMEANDNOCATEGORY ARTICLE
			// Test de la méthode selectByNoCategoryAndCharName de articleDAO
			List<Article> articleListCharNameAndNoCategory = articleDAO.selectByNoCategoryAndCharName(1, "PC");
			System.out.println(
					"============================================================================================");
			for (Article article4 : articleListCharNameAndNoCategory) {
				System.out.println(article4);
			}
			// Test avec erreur

			// =======================================================================================================================================

			// METHODE SELECTALL CATEGORY
			// Test de la méthode selectAll de categoryDAO
			List<Category> categoryList = categoryDAO.selectAll();
			System.out.println(
					"============================================================================================");
			for (Category category : categoryList) {
				System.out.println(category);
			}
		} catch (BusinessException e) {

			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/listOfAuctionsPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}