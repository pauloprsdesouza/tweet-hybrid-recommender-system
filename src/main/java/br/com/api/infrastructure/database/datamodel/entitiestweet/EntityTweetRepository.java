package br.com.api.infrastructure.database.datamodel.entitiestweet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityTweetRepository extends JpaRepository<EntityTweet, EntityTweetPK> {
    @Query(value = "SELECT * FROM entity WHERE id in (?1)", nativeQuery = true)
    public List<EntityTweet> withIds(List<Long> ids);

    @Query(value = "SELECT * FROM entity WHERE id_domain = ?1", nativeQuery = true)
    public List<EntityTweet> withIdDomain(long idDomain);
}
