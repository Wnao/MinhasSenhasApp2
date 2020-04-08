package br.usjt.devmobile.minhassenhasapp;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface SenhaDao {

    @Query("SELECT * FROM senha")
    List<Senha> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:senhaIds)")
    List<User> loadAllByIds(int[] senhaIds);

    @Query("SELECT * FROM senha WHERE senha AND " +
            "usuario LIKE nome LIMIT 1")
    Senha findByName(String senha, String nome);

    @Insert
    void insertAll(Senha... senha);

    @Delete
    void delete(Senha senha);
}
