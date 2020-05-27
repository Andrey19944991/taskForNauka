import React from 'react';
import Table from "./Table/Table";
import './App.css';
import Loader from "./Loader/Loader";
import Months from "./Months/Months";
import Departments from "./Departments/Departments";

class App extends React.Component {


  state ={
    isLoading: true,
    jan: {},
    feb: {},
    march: {},
    april: {},
    may: {},
    june: {},
    july: {},
    aug: {},
    sep: {},
    oct: {},
    nov: {},
    dec: {},
    department: [],
    resMonth:{},
    resDep: {},
  }

  monthClickHandler(index){
    switch (index) {
      case 0:
        this.setState({
          resMonth: {dataOfMonth: this.state.jan.dataOfMonth, countOfDays: this.state.jan.countOfDays, index: 0}
        });
        break;
      case 1:
        this.setState({
          resMonth: {dataOfMonth: this.state.feb.dataOfMonth, countOfDays: this.state.feb.countOfDays, index: 1}
        })
        break;
      case 2:
        this.setState({
          resMonth: {dataOfMonth: this.state.march.dataOfMonth, countOfDays: this.state.march.countOfDays, index: 2}
        })
        break;
      case 3:
        this.setState({
          resMonth: {dataOfMonth: this.state.april.dataOfMonth, countOfDays: this.state.april.countOfDays, index: 3}
        })
        break;
      case 4:
        this.setState({
          resMonth: {dataOfMonth: this.state.may.dataOfMonth, countOfDays: this.state.may.countOfDays, index: 4}
        })
        break;
      case 5:
        this.setState({
          resMonth: {dataOfMonth: this.state.june.dataOfMonth, countOfDays: this.state.june.countOfDays, index: 5}
        })
        break;
      case 6:
        this.setState({
          resMonth: {dataOfMonth: this.state.july.dataOfMonth, countOfDays: this.state.july.countOfDays, index: 6}
        })
        break;
      case 7:
        this.setState({
          resMonth: {dataOfMonth: this.state.aug.dataOfMonth, countOfDays: this.state.aug.countOfDays, index: 7}
        })
        break;
      case 8:
        this.setState({
          resMonth: {dataOfMonth: this.state.sep.dataOfMonth, countOfDays: this.state.sep.countOfDays, index: 8}
        })
        break;
      case 9:
        this.setState({
          resMonth: {dataOfMonth: this.state.oct.dataOfMonth, countOfDays: this.state.oct.countOfDays, index: 9}
        })
        break;
      case 10:
        this.setState({
          resMonth: {dataOfMonth: this.state.nov.dataOfMonth, countOfDays: this.state.nov.countOfDays, index: 10}
        })
        break;
      case 11:
        this.setState({
          resMonth: {dataOfMonth: this.state.dec.dataOfMonth, countOfDays: this.state.dec.countOfDays, index: 11}
        })
        break;
      default:
        this.setState({
          resMonth: {dataOfMonth: this.state.may.dataOfMonth, countOfDays: this.state.may.countOfDays, index: 4}
        })
    }
  }
  departClickHandler(index){
    this.setState({
      resDep: {dataDep: this.state.department[index], index: index}
    })
  }

  async componentDidMount() {
    const response = await fetch(` http://localhost:8080/reports`)
    const data = await response.json();
    let departName = [];
    let jan = [];
    let feb = [];
    let march = [];
    let april = [];
    let may = [];
    let month;

    data.forEach((item) => {
      departName.push(item.employee.department.name);
      month = new Date(item.date);
      if (month.getMonth() === 0) {
        jan.push(item);
      }
      if (month.getMonth() === 1) {
        feb.push(item);
      }
      if (month.getMonth() === 2) {
        march.push(item);
      }
      if (month.getMonth() === 3) {
        april.push(item);
      }
      if (month.getMonth() === 4) {
        may.push(item);
      }
    });
    const depart = Array.from(new Set(departName));
    this.setState({
      jan: {dataOfMonth:jan, countOfDays: 31},
      feb: {dataOfMonth:feb, countOfDays: 29},
      march: {dataOfMonth:march, countOfDays: 31},
      april: {dataOfMonth:april, countOfDays: 30},
      may: {dataOfMonth:may, countOfDays: 31},
      june: {dataOfMonth:[], countOfDays: 30},
      july: {dataOfMonth:[], countOfDays: 31},
      aug: {dataOfMonth:[], countOfDays: 31},
      sep: {dataOfMonth:[], countOfDays: 30},
      oct: {dataOfMonth:[], countOfDays: 31},
      nov: {dataOfMonth:[], countOfDays: 30},
      dec: {dataOfMonth:[], countOfDays: 31},
      department: depart,
      isLoading: false,
      resMonth: {dataOfMonth: may, countOfDays:31, index: 4},
      resDep: {dataDep:depart[0], index: 0}
    })
  }
  render() {
    const monthArr = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
      "November", "December"];
    let months = null;
    months = monthArr.map((month, index) => {
      return (
        <Months
            key={index}
            month={month}
            index={index}
            monthClick={this.monthClickHandler.bind(this, index)}
            currentMonth={this.state.resMonth.index}
        />
    )});

    let department = null;
    department = this.state.department.map((depart, index) => {
      return (
        <Departments
            key={index}
            depart={depart}
            index={index}
            departClick={this.departClickHandler.bind(this, index)}
            currentDep={this.state.resDep.index}
        />
      )
    })
    return (
        <div>
          <div className="btn-group" role="group" aria-label="Basic example">
          {months}
          </div>
          {this.state.isLoading
                ? <Loader />
                :
              <div className="container-fluid">
              <div className="row">
                <div className="col-2">
                <div className="btn-group-vertical" role="group" aria-label="Basic example">
                  {department}
                </div>
                </div>
                <div className="col-10 overflow-auto">
                <Table
                    resMonth={this.state.resMonth.dataOfMonth}
                    department={this.state.resDep.dataDep}
                />
                </div>
              </div>
              </div>
          }
        </div>
    );
  }
}

export default App;
