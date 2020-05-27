import React from "react";
import "./Month.css"

export default props => {

    let inputClass = "btn btn-outline-primary"

    if (props.index === props.currentMonth) {
        inputClass = "btn btn-primary"
    }
        return(
                    <button
                        type="button"
                        className={inputClass}
                        onClick={props.monthClick}
                    >
                        {props.month}
                    </button>
        )

}