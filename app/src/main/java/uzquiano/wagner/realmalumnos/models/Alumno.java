package uzquiano.wagner.realmalumnos.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import uzquiano.wagner.realmalumnos.application.MyApplication;

    public class Alumno extends RealmObject {

        @PrimaryKey
        private int Id;
        private String Rut;
        private String Nombre;
        private String Apellido;
        private int Edad;
        private String Carrera;
        private int Ano;
        private String Semestre;

        public Alumno() {}

        public  Alumno(String rut, String nombre, String apellido, int edad, String carrera, int ano, String semestre){
            Id = MyApplication.AlumnoId.incrementAndGet();
            Rut = rut;
            Nombre = nombre;
            Apellido = apellido;
            Edad = edad;
            Carrera = carrera;
            Ano = ano;
            Semestre = semestre;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getRut() {
            return Rut;
        }

        public void setRut(String rut) {
            Rut = rut;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String nombre) {
            Nombre = nombre;
        }

        public String getApellido() {
            return Apellido;
        }

        public void setApellido(String apellido) {
            Apellido = apellido;
        }

        public int getEdad() {
            return Edad;
        }



        public void setEdad(int edad) {
            Edad = edad;
        }

        public String getCarrera() {
            return Carrera;
        }

        public void setCarrera(String carrera) {
            Carrera = carrera;
        }

        public int getAno() {
            return Ano;
        }

        public void setAno(int ano) {
            Ano = ano;
        }

        public String getSemestre() {
            return Semestre;
        }

        public void setSemestre(String semestre) {
            Semestre = semestre;
        }
    }

