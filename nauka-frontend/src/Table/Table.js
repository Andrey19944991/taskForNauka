import React from "react";
import HeadRow from "./HeadRow";
import MainRows from "./MainRows";
import "./Table.css"

export default class Table extends React.Component {

    render() {
        const data = this.props.resMonth;
        let result = [];
        let names = [];

        data.filter(
            item => item.employee.department.name === this.props.department
        )
            .forEach(item => {
                names.push([item.employee.surname,item.employee.name,item.employee.middle_name].join(" "))
            });
        names = Array.from(new Set(names));
        names.forEach( n => {
            let obj = {};
            data.filter(item =>
                [item.employee.surname,item.employee.name,item.employee.middle_name].join(" ") ===n)
                .forEach((res,index) => {
                    obj['fio'] = n;
                    obj['position'] = res.employee.position
                    obj['tabNumber'] = res.employee.tab_number;
                    obj[index] = res.status;
                })
            result.push(obj);
        });
        return (
            <React.Fragment>
                <table className="table table-bordered">
                    <HeadRow count={this.props.resMonth.countOfDays}/>
                    <MainRows rows={result}
                              count={this.props.resMonth.countOfDays}
                    />
                </table>
            </React.Fragment>
        )
    }
}