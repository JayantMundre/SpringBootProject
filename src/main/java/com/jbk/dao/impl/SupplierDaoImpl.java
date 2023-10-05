package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.dao.SupplierDao;
import com.jbk.model.Address;
import com.jbk.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {

	List<Supplier> list = new ArrayList<>();

	public SupplierDaoImpl() {
		list.add(new Supplier(1l, "Yash Distributor", "9011223344",
				new Address(1l, "pune", "pune", "Maharashtra", "411052")));
		list.add(new Supplier(2l, "Akash Distributor", "9011223355",
				new Address(1l, "pune", "pune", "Maharashtra", "411052")));
		list.add(new Supplier(3l, "Ram Distributor", "9011223356",
				new Address(1l, "pune", "pune", "Maharashtra", "411052")));

	}

	private boolean isExists(Supplier supplier) {

		boolean isExists = false;
		for (Supplier dbSupplier : list) {
			if (supplier.getSupplierName().equalsIgnoreCase(dbSupplier.getSupplierName())
					|| supplier.getSupplierMobileNumber().equals(dbSupplier.getSupplierMobileNumber())) {
				isExists = true;
				break;
			}

		}
		return isExists;
	}

	@Override
	public int addSupplier(Supplier supplier) {
		if (isExists(supplier) == false) {
			list.add(supplier);
			return 1;
		} else {
			return 2;
		}

	}

	@Override
	public Supplier getSupplierById(long supplierId) {

		for (Supplier supplier : list) {
			if (supplier.getSupplierId() == supplierId) {
				return supplier;
			}
		}
		return null;

	}

	@Override
	public List<Supplier> getAllSupplier() {

		return list;
	}

	@Override
	public Object deleteSupplier(long supplierId) {
		int status = 0;
		if (!list.isEmpty()) {
			for (Supplier supplier : list) {
				if (supplier.getSupplierId() == supplierId) {
					list.remove(supplier);
					return list;
				} else {
					status = 1;
				}
			}
		} else {
			status = 2;
		}

		return status;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {

		for (Supplier dbSupplier : list) {

			if (dbSupplier.getSupplierId() == supplier.getSupplierId()) {
				list.set(list.indexOf(dbSupplier), supplier);
				return supplier;
			}
		}

		return null;
	}

}
