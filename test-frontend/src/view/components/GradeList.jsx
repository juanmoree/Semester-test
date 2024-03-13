import React, { useEffect, useState } from "react";
import { listGrades } from "../../logic/listGrades";

export default function GradeList() {
    const [grades, setGrades] = useState([]);

    useEffect(() => {
        listGrades().then((response) => {
            setGrades(response.data);
        }).catch(error => {
            console.error(error);
        });
    }, []);

    /* Inserto los grados de manera manual para ver como se ven */
    const grado1 = {
        id: 12345,
        nombreGrado: "Física"
    }

    const grado2 = {
        id: 12345,
        nombreGrado: "Química"
    }

    const grado3 = {
        id: 12345,
        nombreGrado: "Matemáticas"
    }

    let grados = [grado1, grado2, grado3]

    useEffect(() => {
        setGrades(grados)
    }, [])

    return (
        <div className="container">
            <h2>Listado de Grados</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {grades.map(grade => (
                        <tr key={grade.id}>
                            <td>{grade.id}</td>
                            <td>{grade.nombreGrado}</td>
                            <td>
                                {/* Editar, Eliminar, Ver(Asignaturas) */}
                                <a>Editar</a> |
                                <a>Eliminar</a> |
                                <a>Ver</a>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <a>Agregar Nuevo Grado</a>
        </div>
    );
}
