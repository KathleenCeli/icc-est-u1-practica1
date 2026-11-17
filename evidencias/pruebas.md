# Pruebas realizadas

| Escenario | Resultado esperado | Resultado obtenido | Estado |
| :--- | :--- | :--- | :--- |
| C1 (20 estudiantes) | Ordenados por código de E001 a E020 | Salieron en orden desde E001 hasta E020 | Correcto |
| C2 (20 estudiantes) | Primeros en salir: E005, E010, E014 y E017 | Salieron E005, E010, E014 (Ana) y luego E017 | Correcto |
| C3 (nota 8.5) | Orden: E014, E007, E005, E008, E010 | Se respetó el orden en el que estaban al inicio | Correcto |
| C4 (20 estudiantes) | Primeros en salir: E017, E011 y E001 | Salieron primero E017, E011 y E001 con 9.5 | Correcto |
| C5 (20 estudiantes) | Primeros en salir: E001, E016 y E004 | Salieron E001, E016 y E004 (edad 18, nombre desc) | Correcto |
| C6 (20 estudiantes) | Primeros: E001, E018, E005, E010 y E014 | Coincide exactamente ese orden en Computacion | Correcto |
| C7 (20 estudiantes) | E001 (10.0) primero y E018 (9.7) segundo | E001 quedó con 10.0 y E018 con 9.7 sin cambiar su nota real | Correcto |
| Lista vacía y de 1 dato | No debe dar error al ordenar | Corrió normal sin errores | Correcto |
| Lista original al final | Debe quedar igual que al principio | Mantuvo los 20 registros en su orden inicial | Correcto |