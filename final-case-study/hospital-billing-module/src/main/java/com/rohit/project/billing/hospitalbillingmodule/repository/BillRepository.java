package com.rohit.project.billing.hospitalbillingmodule.repository;

import com.rohit.project.billing.hospitalbillingmodule.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query("from Bill b where b.id=:id")
    public Bill search(int id);
}
