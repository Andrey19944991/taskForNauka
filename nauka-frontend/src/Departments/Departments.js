import React from "react";
import "./Departments.css";

export default props => {
    let inputClass = "btn btn-outline-success"

    if (props.index === props.currentDep) {
        inputClass = "btn btn-success"
    }

    return (
        <button
            type="button"
            className={inputClass}
            onClick={props.departClick}
        >
            {props.depart}
        </button>
    )
}