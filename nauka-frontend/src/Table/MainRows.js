import React from "react";
import "./MainRow.css"

export default (props) => {
    let arr = []
    for (let key in props.rows[0]) {
        if (key!=="fio" && key!=="position" && key!=="tabNumber") {
            arr.push(key)
        }
    }

    return (
        <tbody>
        {props.rows.map((item, index) => {
            return (
                <tr key={index}>
                    <td>{item.fio}</td>
                    <td>{item.position}</td>
                    <td>{item.tabNumber}</td>
                    {arr.map((innerItem, index) => {
                        return (<td key={index}>{item[innerItem]}</td>
                    )
                        })}
                </tr>
            )}
        )}
        </tbody>
    )
}