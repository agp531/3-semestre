package br.edu.ifpr.persistproject.connection;

import br.edu.ifpr.persistproject.repository.SellerRepository;

import java.sql.SQLException;

public class ConnectionTest {

    public static void main(String[] args) throws SQLException {

        SellerRepository sellerRepository = new SellerRepository();

        sellerRepository.getSellers();
    }
}
