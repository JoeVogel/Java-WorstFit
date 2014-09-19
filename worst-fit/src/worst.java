import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class worst {

	public static void main(String args[]) throws IOException {

		int p, m;
		Scanner in = new Scanner(System.in);

		System.out.println("Nº processos:");
		p = in.nextInt();
		System.out.println("Nº blocos de memoria:");
		m = in.nextInt();

		int tamProcessos[] = new int[p];
		SegMemoria segMemoria[] = new SegMemoria[m];

		int i;

		for (i = 0; i < p; i++) {
			System.out.println("Tamanho do processo " + (i + 1));
			tamProcessos[i] = in.nextInt();
		}

		for (i = 1; i <= m; i++) {
			System.out.println("Entre o tamanho do segmento de memoria "
					+ i);
			SegMemoria seg = new SegMemoria();
			seg.id = i;
			seg.size = in.nextInt();
			segMemoria[i-1] = seg;
		}

		int j;
		
                ordenar(segMemoria, m);
                
		for (i = 0; i < p; i++) {
			for (j = 0; j < m; j++) {
				if (segMemoria[j].size >= tamProcessos[i]) {
					segMemoria[j].size -= tamProcessos[i];
					
					System.out.print("Processo " + (i + 1)
							+ " alocado no espaço de memoria " + segMemoria[j].id + ". ");
					System.out.println("Espaço restante após a alocação "
							+ segMemoria[j].size);
                                        ordenar(segMemoria, m);
					
					break;
				}

			}
			if (j == m) {
				System.out.println("Não há mais memoria para o processo " + i);
				break;
			}
		}
	}

    private static void ordenar(SegMemoria segMemoria[], int m) {
        int i,j;
        for (i = 0; i < m; i++) {
			for (j = i + 1; j < m; j++) {
				if (segMemoria[i].size < segMemoria[j].size) {
					SegMemoria t = segMemoria[i];
					segMemoria[i] = segMemoria[j];
					segMemoria[j] = t;
                                        
				}
			}
		}
    }
}
