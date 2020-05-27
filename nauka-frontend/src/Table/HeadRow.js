import React from "react";
import "./HeadRow.css"

export default (props) => {
    let arr = [];
    for (let i = 0; i < props.count; i++) {
            arr.push(<th key={i}>{i+1}</th>)
    }
    return (
        <thead>
        <tr>
            <th className="main">ФИО</th>
            <th className="main">Должность</th>
            <th className="main">Таб. номер</th>
            {arr}
        </tr>
        </thead>
    )
}