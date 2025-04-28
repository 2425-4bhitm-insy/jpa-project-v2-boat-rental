package htl.leonding.rental.control;

import htl.leonding.rental.entity.Lease;

import java.util.List;

public interface LeaseRepository {
    void add(Lease lease);
    void remove(Lease lease);
    Lease getLease(Long leaseId);
    List<Lease> getAllLeases();
}