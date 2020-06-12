package com.changwu.repository;

import com.changwu.bean.FlowDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlowDetailRepository extends JpaRepository<FlowDetail,Integer> {

   // @Query(value="select c.id,c.username from user c ,(select a.id, a.username,a.parentrole  from user a inner join user b where a.parentrole = b.id) d where d.parentrole = c.id ;")
   // List<String>  findLeadersByUsername(String username);
}
