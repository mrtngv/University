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
            primary-title="CSCB536"
            secondary-title="Бази Данни. Разработка номер 10"
        >
        </ui5-shellbar>
        <div className="sidenav">
          <ui5-side-navigation id="side-navigation">

              <ui5-side-navigation-item text="Университети" icon="sap-icon://product" id="universities"></ui5-side-navigation-item>
              <ui5-side-navigation-item text="Студенти" icon="sap-icon://product" id="students"></ui5-side-navigation-item>
              <ui5-side-navigation-item text="Програми" icon="sap-icon://sys-find" id="programs"></ui5-side-navigation-item>
              <ui5-side-navigation-item text="Кандидатствания" icon="sap-icon://functional-location" id="offices"></ui5-side-navigation-item>
              <ui5-side-navigation-item text="За компанията" icon="sap-icon://building" id="company"></ui5-side-navigation-item>
          </ui5-side-navigation>          
        </div>
      </div>
    )
  }
}

export default Navbar;