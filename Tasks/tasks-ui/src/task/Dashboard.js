import React from "react"
import ReactApexChart from 'react-apexcharts';
import "@ui5/webcomponents/dist/Card";
import '../styles/style.css';
import axios from 'axios';

class Dashboard extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            dashboardDetails: {},
            seriesSystems: [1,2],
            cc: {},
            optionsSystems: {
                labels: ['Завършени', 'Да се направят'],
                colors: ['#4CAF50', '#F9C80E'],
                chart: {
                    type: 'donut',
                },
            },
            s1: [],
            s2: [],
            seriesInstances: [1,5],
            optionsInstances: {
                labels: ['Завършени', 'Да се направят'],
                colors: ['#4CAF50', '#919191'],
                chart: {
                    type: 'donut',
                },
            }
        }
    }

    setDashboardInfo() {
        // this.setState({
        //     seriesSystems: [
        //         this.props.dashboardDetails.runningSystems,
        //         this.props.dashboardDetails.stoppedSystems,
        //         this.props.dashboardDetails.intermediateSystems],
        //     seriesInstances: [
        //         this.props.dashboardDetails.runningInstances,
        //         this.props.dashboardDetails.stoppedInstances,
        //     ]
        // })
    }

    // "finished": 4,
    // "todo": 8,
    // "dateTodo": 2,
    // "dateFinished": 1

    componentDidMount() {
        axios.get("http://localhost:5000/api/task/api/dashboard").then(r => {
            this.setState({
                cc: r.data[0],
                s1: [r.data[0].finished, r.data[0].todo],
                s2: [r.data[0].dateFinished, r.data[0].dateTodo]
            })
        })
    }

    render() {
        return (
            <div className="dashboard">
                <div className="dashboard-card">
                    <ui5-card  heading="Общо задачи" subheading={ "(" + (this.state.cc.finished+this.state.cc.todo)+ ")"}>
                        <ReactApexChart options={this.state.optionsSystems} series={this.state.s1} type="donut" width="450" />
                    </ui5-card>
                </div>
                <div className="dashboard-card">
                <ui5-card heading="Задачи за седем дена назад от днес" subheading={"(" + (this.state.cc.dateTodo+this.state.cc.dateFinished)+  ")"}>
                    <ReactApexChart options={this.state.optionsInstances} series={this.state.s2} type="donut" width="450" />
                </ui5-card>
                </div>
            </div>

        )
    }
}


export default Dashboard;