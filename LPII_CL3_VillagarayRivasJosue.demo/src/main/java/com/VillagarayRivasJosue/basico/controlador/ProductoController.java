package com.VillagarayRivasJosue.basico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.VillagarayRivasJosue.basico.modelo.ClassProductocl3;
import com.VillagarayRivasJosue.basico.servicio.IProductoServicio;

@Controller
@RequestMapping("/Vistas")
public class ProductoController {
	//inyeccion de dependencias
		@Autowired
		private IProductoServicio iproductoservicio;
		
		@GetMapping("ListadoProducto")
		public String ListadoProducto(Model modelo) {
			List<ClassProductocl3> listado=iproductoservicio.ListadoProductos();
			//testeo
			for(ClassProductocl3 lis:listado) {
				System.out.println(" codigo "+lis.getIdproductocl3()+" "+" modelo "+lis.getNombrecl3());
			}
			//----------
			modelo.addAttribute("listado", listado);
			return "/Vistas/ListadoProductos";
		}// fin del metodo
		
		@GetMapping("/RegistrarProducto")
		public String RegistrarProducto(Model modelo) {
			ClassProductocl3 clapro = new ClassProductocl3();
			//enviar
			modelo.addAttribute("regpro",clapro);
			return "/Vistas/CrearProducto";
		}
		
		@PostMapping("/GuardarProducto")
		public String GuardarProducto(@ModelAttribute ClassProductocl3 clapro,Model modelo) {
			iproductoservicio.Registrar(clapro);
			System.out.println("Datos registrado en la BD!");
			return "redirect:/Vistas/ListadoProducto";
		}
		
		@GetMapping ("/editar/{id}")
		public String Editar(@PathVariable("id") Integer idproductocl3,Model modelo) {
			ClassProductocl3 clapro=iproductoservicio.BuscarporId(idproductocl3);
			modelo.addAttribute("regpro", clapro);
			return ("/Vistas/CrearProducto");
		}
		
		@GetMapping("/eliminar/{id}")
		public String Eliminar(@PathVariable("id") Integer idauto,Model modelo) {
			//inyeccion de dependencias
			iproductoservicio.Eliminar(idauto);
		    List<ClassProductocl3> listado = iproductoservicio.ListadoProductos();
		    //enviamos a la vista
		    modelo.addAttribute("listado", listado);
		    //redireccionamos
			return "redirect:/Vistas/ListadoProducto";
		
		}
		
		

	}
