package controlador;



/**
 * <h1>Clock</h1>
 * Clock es una ejercicio de una práctica de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * Clock es la clase que implementa un cronometro para medir el tiempo de ejecución de 
 * un código.
 *  
 * @author  Carlos Troyano Carmona
 * @version 1.0  
 * @since  13 de mar. de 2016 
 */
public class Clock {
        
        /**
         * Tiempo inical del reloj para el calculo. Suele ser 0.
         */
        private long time_inicial;
        /**
         * 
         */
        private double time_total;
        boolean started;
        
        public Clock() {
            setTimeInicial(0);
            setTimeTotal(0);
        }
    
        void Start() {
            setTimeInicial(System.nanoTime());
            started = true;
        }
        
        public long getTimeInicial() {
            return time_inicial;
        }

        public void setTimeInicial(long l) {
            this.time_inicial = l;
        }
        
        public double getTimeTotal() {
            return time_total;
        }

        public void setTimeTotal(int time) {
            this.time_total = time;
        }


        void Stop() {
            started = false;
            time_total = Double.valueOf(System.nanoTime()-getTimeInicial())*0.000000001;
        }
        
        void reset() {
            setTimeInicial(0);
            setTimeTotal(0);
        }
        
        boolean isStarted() {
            return started;
        }
//        
//        temporizador.Start();
//        new ControladorCambioDivisas(numero);
//        temporizador.Stop();
//        System.out.println((float)Math.round(temporizador.getTimeTotal() * 100) / 100 + " segundos");
}