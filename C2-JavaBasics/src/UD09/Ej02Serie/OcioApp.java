
package UD09.Ej02Serie;

public class OcioApp {

	public static void main(String[] args) {
		Serie Lost = new Serie("Lost", 6, "thriller", "J. J. Abrams");
		Serie BreakingBad = new Serie("Beaking Bad", 5, "drama", "Vince Gilligan");
		Serie Buffy = new Serie("Buffy the Vampire Slayer", 7, "drama", "Joss Whedon");
		Serie Serrano = new Serie("Los Serrano", 8, "comedia", "Daniel Écija");
		Serie Simpson = new Serie("The Simpsons", 36, "comedia", "Matt Groening");

		Videojuego MGS3 = new Videojuego("Metal Gear Solid 3: Snake Eater", 16, "acción", "Konami");
		Videojuego MegaMan11 = new Videojuego("Mega Man 11", 5, "plataformas", "Capcom");
		Videojuego FatalFrame = new Videojuego("Fatal Frame/Project Zero", 7, "terror", "Tecmo");
		Videojuego SilentHill = new Videojuego("Silent Hill", 7, "survival horror", "Konami");
		Videojuego DMCV = new Videojuego("Devil May Cry V", 9, "acción", "Capcom");

		Entregable[] ocio = { Lost, BreakingBad, Buffy, Serrano, Simpson, MGS3, 
				MegaMan11, FatalFrame, SilentHill, DMCV };
		Lost.entregar();
		SilentHill.entregar();
		DMCV.entregar();
		Buffy.entregar();

		int entregados = contarMostrarEntregados(ocio);
		entregados = devolverItemsEntregados(ocio, entregados);

		System.out.println("Hay " + entregados + " series y videojuegos entregados.");

		valorMasAlto(ocio);
	}

	private static int contarMostrarEntregados(Entregable[] ocio) {
		int entregados = 0;
		for (Entregable item : ocio) {
			if (item.isEntregado()) {
				String titulo = "";
				if (item instanceof Serie) {
					titulo = ((Serie) item).getTitulo();
				} else if (item instanceof Videojuego) {
					titulo = ((Videojuego) item).getTitulo();
				}
				System.out.println("Se ha entregado " + titulo + ".");
				entregados++;
			}
		}
		System.out.println("Hay " + entregados + " series y videojuegos entregados.");
		return entregados;
	}

	private static int devolverItemsEntregados(Entregable[] ocio, int entregados) {
		for (Entregable item : ocio) {
			if (item.isEntregado()) {
				String titulo = "";
				if (item instanceof Serie) {
					titulo = ((Serie) item).getTitulo();
				} else if (item instanceof Videojuego) {
					titulo = ((Videojuego) item).getTitulo();
				}
				item.devolver();
				entregados--;
				System.out.println("Se ha devuelto " + titulo + ".");
			}
		}
		return entregados;
	}

	private static void valorMasAlto(Entregable[] ocio) {
		int maxNumTemp = 0;
		int maxHoras = 0;
		String serieInfo = "";
		String videojuegoInfo = "";

		for (Entregable item : ocio) {
			if (item instanceof Serie) {
				Serie serie = (Serie) item;
				if (serie.getNumTemp() > maxNumTemp) {
					maxNumTemp = serie.getNumTemp();
					serieInfo = serie.toString();
				}
			} else if (item instanceof Videojuego) {
				Videojuego videojuego = (Videojuego) item;
				if (videojuego.getHorasEstimadas() > maxHoras) {
					maxHoras = (int) videojuego.getHorasEstimadas();
					videojuegoInfo = videojuego.toString();

				}
			}
		}
		System.out.println("Serie con más temporadas: " + serieInfo);
		System.out.println("Videojuego con más horas de juego estimadas: " + videojuegoInfo);
	}
}
