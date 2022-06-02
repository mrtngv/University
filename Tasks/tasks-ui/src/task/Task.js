import React from 'react';
import axios from 'axios';
import "@ui5/webcomponents/dist/Table.js";
import "@ui5/webcomponents/dist/TableColumn.js";
import "@ui5/webcomponents/dist/TableRow.js";
import "@ui5/webcomponents/dist/TableCell.js";
import "../navbar/Navbar.css";
import "@ui5/webcomponents/dist/Input.js";
import "@ui5/webcomponents/dist/Link";

class Task extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tasks: [],
        };

        this.handleInputValue = this.handleInputValue.bind(this);
        this.populate = this.populate.bind(this);
    }

    addEventListeners(){
        document.querySelectorAll('.input').forEach(item => {
            item.addEventListener("change", this.handleInputValue);
          })
    }

    populate () {
        axios.get('http://localhost:5000/api/task').then(r => {
            this.setState({
                tasks: r.data
            })
        })
    }

    componentDidMount() {
        this.addEventListeners();
        this.populate();
    }

    handleInputValue(event) {
        const { name, value } = event.target;
        this.setState({
            [name]: value
        });
        console.log(this.state.requestDate);
    }

    render() {
        return (
            <div className="right aba">
                <ui5-table class="demo-table" id="table">
                    <ui5-table-column slot="columns" >
                        <span>ID</span>
                    </ui5-table-column>

                    <ui5-table-column slot="columns">
                        <span>Задача</span>
                    </ui5-table-column>

                    <ui5-table-column slot="columns" >
                        <span>Коментар</span >
                    </ui5-table-column>

                    <ui5-table-column slot="columns">
                        <span>Дата</span>
                    </ui5-table-column> 

                    <ui5-table-column slot="columns">
                        <span>Статус</span>
                    </ui5-table-column>

                    {this.state.tasks.map((u) => (
                        <ui5-table-row>
                            <ui5-table-cell>
                                {u.TaskId}
                            </ui5-table-cell>
                            <ui5-table-cell>
                            <ui5-link href={"http://localhost:3000/#/search/" + u.TaskId} target="_self">{u.TaskName}</ui5-link>            
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.TaskDescription}
                            </ui5-table-cell>
                            <ui5-table-cell>
                            {u.TaskDate.substr(0, 10)}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.TaskDone}
                            </ui5-table-cell>
                        </ui5-table-row>
                    ))}
                </ui5-table>
                {/* <div className="sit">
                <div className="down">
                    <b>Въвеведи Университет</b>
                </div>


                <div className="go">
                    <ui5-label for="senderLastNameInput" required>Име На Университет</ui5-label><br />
                    <ui5-input class="input" id="senderLastNameInput" value= {this.state.name} name="name" placeholder="" required></ui5-input><br />
                </div>
                <div className="go">
                    <ui5-label for="senderLastNameInput" required>Град</ui5-label><br />
                    <ui5-input class="input" id="senderLastNameInput"  value = {this.state.city} name="city" placeholder="" required></ui5-input><br />
                </div>
                <div className="go">
                    <ui5-label for="senderLastNameInput" required>Държава</ui5-label><br />
                    <ui5-input class="input" id="senderLastNameInput" name="country" value={this.state.country} placeholder="" required></ui5-input><br />
                </div>
                <div className="go">
                <ui5-button design="Default" onClick={this.submit}>Въвеведи</ui5-button>
                </div>
</div> */}
            </div>
        )
    }
}

export default Task;