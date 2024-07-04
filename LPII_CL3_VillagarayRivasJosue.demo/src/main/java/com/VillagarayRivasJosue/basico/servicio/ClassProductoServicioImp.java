package com.VillagarayRivasJosue.basico.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VillagarayRivasJosue.basico.modelo.ClassProductocl3;
import com.VillagarayRivasJosue.basico.repositorio.IProductoRepository;

@Service
public class ClassProductoServicioImp implements IProductoServicio {

	//inyeccion de dependecias
	@Autowired
	private IProductoRepository iproductorepository;
	
	@Override
	public List<ClassProductocl3> ListadoProductos() {
		// 
		return (List<ClassProductocl3>) iproductorepository.findAll();
	}

	@Override
	public void Registrar(ClassProductocl3 clapro) {
		// TODO Auto-generated method stub
		iproductorepository.save(clapro);
	}

	@Override
	public ClassProductocl3 BuscarporId(Integer id) {
		// TODO Auto-generated method stub
		return iproductorepository.findById(id).orElse(null);
	}

	@Override
	public void Eliminar(Integer id) {
		/// TODO Auto-generated method stub
		iproductorepository.deleteById(id);
		
	}
}

