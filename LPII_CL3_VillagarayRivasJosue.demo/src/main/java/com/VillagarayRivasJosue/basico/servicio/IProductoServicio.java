package com.VillagarayRivasJosue.basico.servicio;

import java.util.List;

import com.VillagarayRivasJosue.basico.modelo.ClassProductocl3;

public interface IProductoServicio {
	
	//declaramos metodos
	public List<ClassProductocl3> ListadoProductos();
	public void Registrar(ClassProductocl3 clapro);
	public ClassProductocl3 BuscarporId(Integer id);
	public void Eliminar(Integer id);

}

