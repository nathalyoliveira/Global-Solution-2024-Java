package br.com.fiap.EcoSynergy.Packsdb;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PckInserts {
//
//	@Autowired
//    private JdbcTemplate jdbcTemplate;
//
////    public PckInserts(JdbcTemplate jdbcTemplate) {
////        this.jdbcTemplate = jdbcTemplate;
////    }
//
//    public void inserirAlerta(String dsAlerta, String dsStatus, Long idConsumo) {
//        String sql = "CALL pck_inserts_db.p_inserir_alerta(?, ?, ?)";
//        jdbcTemplate.update(sql, dsAlerta, dsStatus, idConsumo);
//    }
//
//    public void inserirConsumo(Double nrKwh, java.sql.Date dtConsumo, Long idSensor) {
//        String sql = "CALL pck_inserts_db.p_inserir_consumo(?, ?, ?)";
//        jdbcTemplate.update(sql, nrKwh, dtConsumo, idSensor);
//    }
//
//    public void inserirEquipamento(String dsNome, String dsTipo) {
//        String sql = "CALL pck_inserts_db.p_inserir_equipamento(?, ?)";
//        jdbcTemplate.update(sql, dsNome, dsTipo);
//    }
//
//    public void inserirLocal(String dsNome, Long idUsuario) {
//        String sql = "CALL pck_inserts_db.p_inserir_local(?, ?)";
//        jdbcTemplate.update(sql, dsNome, idUsuario);
//    }
//
//    public void inserirRecomendacao(String dsRecomendacao, String dsStatus, String dsPrioridade, Long idSensor) {
//        String sql = "CALL pck_inserts_db.p_inserir_recomendacao(?, ?, ?, ?)";
//        jdbcTemplate.update(sql, dsRecomendacao, dsStatus, dsPrioridade, idSensor);
//    }
//
//    public void inserirSensor(String dsStatus, Double nrConsumoPadrao, Long idEquipamento, Long idLocal) {
//        String sql = "CALL pck_inserts_db.p_inserir_sensor(?, ?, ?, ?)";
//        jdbcTemplate.update(sql, dsStatus, nrConsumoPadrao, idEquipamento, idLocal);
//    }
//
//    public void inserirUsuario(String dsNome, String dsEmail, String dsSenha) {
//        String sql = "CALL pck_inserts_db.p_inserir_usuario(?, ?, ?)";
//        jdbcTemplate.update(sql, dsNome, dsEmail, dsSenha);
//    }
//}


import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PckInserts {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserirAlerta(String dsAlerta, String dsStatus, Long idConsumo) {
        entityManager.createNativeQuery("CALL pck_inserts_db.p_inserir_alerta(?, ?, ?)")
                     .setParameter(1, dsAlerta)
                     .setParameter(2, dsStatus)
                     .setParameter(3, idConsumo)
                     .executeUpdate();
    }

    @Transactional
    public void inserirConsumo(Double nrKwh, java.sql.Date dtConsumo, Long idSensor) {
        entityManager.createNativeQuery("CALL pck_inserts_db.p_inserir_consumo(?, ?, ?)")
                     .setParameter(1, nrKwh)
                     .setParameter(2, dtConsumo)
                     .setParameter(3, idSensor)
                     .executeUpdate();
    }

    @Transactional
    public void inserirEquipamento(String dsNome, String dsTipo) {
        entityManager.createNativeQuery("CALL pck_inserts_db.p_inserir_equipamento(?, ?)")
                     .setParameter(1, dsNome)
                     .setParameter(2, dsTipo)
                     .executeUpdate();
    }

    @Transactional
    public void inserirLocal(String dsNome, Long idUsuario) {
        entityManager.createNativeQuery("CALL pck_inserts_db.p_inserir_local(?, ?)")
                     .setParameter(1, dsNome)
                     .setParameter(2, idUsuario)
                     .executeUpdate();
    }

    @Transactional
    public void inserirRecomendacao(String dsRecomendacao, String dsStatus, String dsPrioridade, Long idSensor) {
        entityManager.createNativeQuery("CALL pck_inserts_db.p_inserir_recomendacao(?, ?, ?, ?)")
                     .setParameter(1, dsRecomendacao)
                     .setParameter(2, dsStatus)
                     .setParameter(3, dsPrioridade)
                     .setParameter(4, idSensor)
                     .executeUpdate();
    }

    @Transactional
    public void inserirSensor(String dsStatus, Double nrConsumoPadrao, Long idEquipamento, Long idLocal) {
        entityManager.createNativeQuery("CALL pck_inserts_db.p_inserir_sensor(?, ?, ?, ?)")
                     .setParameter(1, dsStatus)
                     .setParameter(2, nrConsumoPadrao)
                     .setParameter(3, idEquipamento)
                     .setParameter(4, idLocal)
                     .executeUpdate();
    }

    @Transactional
    public void inserirUsuario(String dsNome, String dsEmail, String dsSenha) {
        entityManager.createNativeQuery("CALL pck_inserts_db.p_inserir_usuario(?, ?, ?)")
                     .setParameter(1, dsNome)
                     .setParameter(2, dsEmail)
                     .setParameter(3, dsSenha)
                     .executeUpdate();
    }
}

