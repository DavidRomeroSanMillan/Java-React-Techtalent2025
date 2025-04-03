package UD09.Ej01Electro;;


public class ElectroApp {

	public static void main(String[] args) {
			
			Lavadora Siemens = new Lavadora ();
			Siemens.mostrar();
			Lavadora Balay = new Lavadora (200, 20);
			Balay.mostrar();
			Lavadora Fagor = new Lavadora (500.0, "rojo", "C", 200.0, 35.0);
			Fagor.mostrar();
			
			Televisor Sony = new Televisor();
			Sony.mostrar();
			Televisor Huawei = new Televisor(150, 25);
			Huawei.mostrar();
			Televisor HP = new Televisor(250, "negro", "B", 25, 50, true);
			HP.mostrar();
		}

	}


