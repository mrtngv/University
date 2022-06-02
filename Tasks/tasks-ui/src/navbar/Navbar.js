import React from 'react';
import "./Navbar.css";
import "@ui5/webcomponents-fiori/dist/ShellBar";
import "@ui5/webcomponents-fiori/dist/SideNavigation.js";
import "@ui5/webcomponents-fiori/dist/SideNavigationItem.js";
import "@ui5/webcomponents-fiori/dist/SideNavigationSubItem.js";


class Navbar extends React.Component {
  constructor(props) {
    super(props);
    this.onNavbarSelect = this.onNavbarSelect.bind(this);
}

  onNavbarSelect(event) {
    const newRoute = event.detail.item.id;
    this.props.history.push(('/' + newRoute));
  }

  onSidebarCollapse() {
    const sidenav = document.getElementById('side-navigation');
    sidenav.collapsed = !sidenav.collapsed;
  }


addEventListeners() {
    const navigation = document.getElementById('side-navigation');
    navigation.addEventListener("selection-change", this.onNavbarSelect);
}

componentDidMount() {
  this.addEventListeners();
}

  render() {
    return (
      <div>
        <ui5-shellbar 
            className="shellbar"
            id="shellbar"
            primary-title="Мартин Георгиев"
            secondary-title="CSCB766 Програмиране с ASP .NET. Проект - Списък със задачи"
        >
        </ui5-shellbar>
        <div className="sidenav">
          <ui5-side-navigation id="side-navigation">
             <ui5-side-navigation-item text="Dashboard" icon="sap-icon://product" id="dashboard"></ui5-side-navigation-item>
              <ui5-side-navigation-item text="Всички Задачи" icon="sap-icon://product" id="tasks"></ui5-side-navigation-item>
              <ui5-side-navigation-item text="Конкретна Задача" icon="sap-icon://product" id="search"></ui5-side-navigation-item>
              <ui5-side-navigation-item text="Добави Задача" icon="sap-icon://product" id="tasks/add"></ui5-side-navigation-item>
          </ui5-side-navigation>          
        </div>
      </div>
    )
  }
}

export default Navbar;