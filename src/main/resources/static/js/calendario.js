meses = ["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"];
lasemana = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"]
diassemana = ["lun", "mar", "mie", "jue", "vie", "sab", "dom"];

window.onload = function () {

    hoy = new Date(); //objeto fecha actual
    diasemhoy = hoy.getDay(); //dia semana actual
    diahoy = hoy.getDate(); //dia mes actual
    meshoy = hoy.getMonth(); //mes actual
    annohoy = hoy.getFullYear(); //año actual

    tit = document.getElementById("titulos"); //cabecera del calendario
    ant = document.getElementById("anterior"); //mes anterior
    pos = document.getElementById("posterior"); //mes posterior

    f0 = document.getElementById("fila0");

    pie = document.getElementById("fechaactual");
    pie.innerHTML += lasemana[diasemhoy] + ", " + diahoy + " de " + meses[meshoy] + " de " + annohoy;

    document.buscar.buscaanno.value = annohoy;

    mescal = meshoy; //mes principal
    annocal = annohoy //año principal

    cabecera()
    primeralinea()
    escribirdias()
}

function cabecera() {
    tit.innerHTML = meses[mescal] + " de " + annocal;
    mesant = mescal - 1; //mes anterior
    mespos = mescal + 1; //mes posterior
    if (mesant < 0) {
        mesant = 11;
    }
    if (mespos > 11) {
        mespos = 0;
    }
    ant.innerHTML = meses[mesant]
    pos.innerHTML = meses[mespos]
}

function primeralinea() {
    for (i = 0; i < 7; i++) {
        celda0 = f0.getElementsByTagName("th")[i];
        celda0.innerHTML = diassemana[i]
    }
}

function escribirdias() {
    //Buscar dia de la semana del dia 1 del mes:
    primeromes = new Date(annocal, mescal, "1") //buscar primer día del mes
    prsem = primeromes.getDay() //buscar día de la semana del día 1
    prsem--; //adaptar al calendario español (empezar por lunes)
    if (prsem == -1) {
        prsem = 6;
    }
    //buscar fecha para primera celda:
    diaprmes = primeromes.getDate()
    prcelda = diaprmes - prsem; //restar días que sobran de la semana
    empezar = primeromes.setDate(prcelda) //empezar= tiempo UNIX 1ª celda
    diames = new Date() //convertir en fecha
    diames.setTime(empezar); //diames=fecha primera celda.
    for (i = 1; i < 7; i++) { //localizar fila
        fila = document.getElementById("fila" + i);
        for (j = 0; j < 7; j++) {
            midia = diames.getDate()
            mimes = diames.getMonth()
            mianno = diames.getFullYear()
            celda = fila.getElementsByTagName("td")[j];
            celda.innerHTML = midia;
            //Recuperar estado inicial al cambiar de mes:
            celda.style.backgroundColor = "#a4cfe5";
            celda.style.color = "#120012";
            //domingos en rojo
            if (j == 6) {
                celda.style.color = "#f11445";
            }
            //dias restantes del mes en gris
            if (mimes != mescal) {
                celda.style.color = "#796373";
            }
            //destacar la fecha actual
            //pasar al siguiente día
            midia = midia + 1;
            diames.setDate(midia);
            /* var listaob = document.getElementById("info").getAttribute("value");
             for(var z=0;x<listaob.length;z++){
                 var obj = listaobj[z];
                 var d = new String(obj.fecha);
 
                 if(date == d.getDate() && month == d.getMonth() && year == d.getFullYear()){
                     var btn = document.createElement("BUTTON");
                     var t= document.createTextNode("CITA");
                     btn.appendChild(t);
                     var att = document.createAttribute("onclick");
                     att.value="imprimir(" + obj.asunto + ' ' + obj.medico+ ' ' + obj.fecha + ' ' + obj.hora +")";
                     btn.setAttributeNode(att);
                     celda.appendChild(btn);
                     break;
                 }
 
             }*/

        }
    }
}

function mesantes() {
    nuevomes = new Date() //nuevo objeto de fecha
    primeromes--; //Restamos un día al 1 del mes visualizado
    nuevomes.setTime(primeromes) //cambiamos fecha al mes anterior
    mescal = nuevomes.getMonth() //cambiamos las variables que usarán las funciones
    annocal = nuevomes.getFullYear()
    cabecera() //llamada a funcion de cambio de cabecera
    escribirdias() //llamada a funcion de cambio de tabla.
}

function mesdespues() {
    nuevomes = new Date() //nuevo obejto fecha
    tiempounix = primeromes.getTime() //tiempo de primero mes visible
    tiempounix = tiempounix + (45 * 24 * 60 * 60 * 1000) //le añadimos 45 días
    nuevomes.setTime(tiempounix) //fecha con mes posterior.
    mescal = nuevomes.getMonth() //cambiamos variables
    annocal = nuevomes.getFullYear()
    cabecera() //escribir la cabecera
    escribirdias() //escribir la tabla

}

function actualizar() {
    mescal = hoy.getMonth(); //cambiar a mes actual
    annocal = hoy.getFullYear(); //cambiar a año actual
    cabecera() //escribir la cabecera
    escribirdias() //escribir la tabla

}

function mifecha() {
    //Recoger dato del año en el formulario
    mianno = document.buscar.buscaanno.value;
    //recoger dato del mes en el formulario
    listameses = document.buscar.buscames;
    opciones = listameses.options;
    num = listameses.selectedIndex
    mimes = opciones[num].value;
    //Comprobar si el año está bien escrito
    if (isNaN(mianno) || mianno < 1) {
        //año mal escrito: mensaje de error
        alert("El año no es válido:\n debe ser un número mayor que 0")
    } else { //año bien escrito: ver mes en calendario:
        mife = new Date(); //nueva fecha
        mife.setMonth(mimes); //añadir mes y año a nueva fecha
        mife.setFullYear(mianno);
        mescal = mife.getMonth(); //cambiar a mes y año indicados
        annocal = mife.getFullYear();
        cabecera() //escribir cabecera
        escribirdias() //escribir tabla
    }

}

function escribircita() {
    cita = document.getElementsByName(Cita);
    mens = document.getElementById("ms")
    document.write("hola")
}

function colorc(celda) {
    celda.style.backgroundColor = "#ffa979";
}

function coloro(celda) {
    celda.style.backgroundColor = "#a4cfe5";
}

