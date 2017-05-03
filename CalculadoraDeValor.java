
public class CalculadoraDeValor {
	
	private static final float VALOR_FRACAO = (float) 2.0;
	private static final float VALOR_HORA = (float) 7.0;
	private static final float VALOR_DIARIA = (float) 30.0;

	public float calcularValor(int horaSaida, int horaEntrada, int minutosSaida, int minutosEntrada) { 
		final int quantidadeHoras = horaSaida - horaEntrada; 
		final int quantidadeMinutos; 
		
		if (horaSaida == horaEntrada){
			quantidadeMinutos = minutosSaida - minutosEntrada;
			return calcularTotal(quantidadeHoras, quantidadeMinutos);
		}
		else if (horaSaida > horaEntrada && minutosEntrada == minutosSaida){
			final int quantidadeMinutosZerados = 0;
			return calcularTotal(quantidadeHoras, quantidadeMinutosZerados);
		}
		else if (horaSaida > horaEntrada && minutosEntrada > minutosSaida){
			final int quantidadeMinutosEntradaMaior = minutosSaida - minutosEntrada;
			return calcularTotal(quantidadeHoras, quantidadeMinutosEntradaMaior);	
		}
		else if (horaSaida > horaEntrada && minutosSaida < minutosEntrada){
			final int quantidadeMinutosSaidaMenor = minutosSaida + (60 - minutosEntrada);
			final int quantidadeHorasMinutosSaidaMenor = horaSaida - horaEntrada - 1;
			return calcularTotal(quantidadeHorasMinutosSaidaMenor, quantidadeMinutosSaidaMenor);
		}
		else {
			final int quantidadeHorasDefault = 0;
			final int quantidadeMinutosDefault = 0;
			return calcularTotal(quantidadeHorasDefault, quantidadeMinutosDefault);
		}
	}
	
	public float calcularTotal(int quantidadeHoras, int quantidadeMinutos){
		float valorTotal = 0; 
		valorTotal += quantidadeHoras * VALOR_HORA;
		valorTotal += Math.ceil(quantidadeMinutos / 15.0) * VALOR_FRACAO;		
		
		if (quantidadeHoras >=9)
			return VALOR_DIARIA;
		else 
			return valorTotal;
	}
}
