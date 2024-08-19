// /**
//  * @license
//  * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
//  * Licensed under The Universal Permissive License (UPL), Version 1.0
//  * as shown at https://oss.oracle.com/licenses/upl/
//  * @ignore
//  */
// import * as AccUtils from "../accUtils";
// import * as ko from "knockout";
// import "oj-c/input-text";
// import "ojs/ojknockout";
// import "oj-c/input-number";
// import "oj-c/input-password";
// import "oj-c/button";

// class IncidentsViewModel {
//   name: ko.Observable<string> | ko.Observable<any>;
//   email: ko.Observable<string> | ko.Observable<any>;
//   mobileno: ko.Observable<string> | ko.Observable<any>;
//   address: ko.Observable<string> | ko.Observable<any>;
//   state: ko.Observable<string> | ko.Observable<any>;
//   country: ko.Observable<string> | ko.Observable<any>;
//   username: ko.Observable<string> | ko.Observable<any>;
//   password: ko.Observable<string> | ko.Observable<any>;

//   constructor() {
//     this.name = ko.observable("");
//     this.email = ko.observable("");
//     this.mobileno = ko.observable("");
//     this.address = ko.observable("");
//     this.state = ko.observable("");
//     this.country = ko.observable("");
//     this.username = ko.observable("");
//     this.password = ko.observable("");
//   }

//   async register() {
//     const response = await fetch("http://localhost:8080/BankingApp/register", {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify({
//         customerName: this.name(),
//         customer_email: this.email(),
//         customerPhone: this.mobileno(),
//         customerAddress: this.address(),
//         customerState: this.state(),
//         customerCountry: this.country(),
//         customerLoginId: this.username(),
//         customerPassword: this.password(),
//       }),
//     });

//     if (response.ok) {
//       const user = await response.text();
//       console.log("Registration successful:", user);
//     } else {
//       console.error("Registration failed");
//     }
//   }
// }

// export = IncidentsViewModel;

/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */

import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import * as Bootstrap from "ojs/ojbootstrap";
import "oj-c/input-number";
import "oj-c/input-text";
import "ojs/ojknockout";
import "ojs/ojknockout";
import Message = require("ojs/ojmessaging");
import "oj-c/input-password";
import "ojs/ojlabel";
import * as ResponsiveUtils from "ojs/ojresponsiveutils";
import { IntlConverterUtils } from "ojs/ojconverterutils-i18n";
import { ojDatePicker } from "ojs/ojdatetimepicker";
import "ojs/ojknockout";
import "ojs/ojdatetimepicker";
import "ojs/ojlabel";
import "oj-c/form-layout";
import "knockout";
import "ojs/ojknockout";
import "oj-c/button";

class IncidentsViewModel {
  name: ko.Observable<string>;
  email: ko.Observable<string>;
  mobileno: ko.Observable<string>;
  address: ko.Observable<string>;
  state: ko.Observable<string>;
  country: ko.Observable<string>; 
  username: ko.Observable<string>;
  password: ko.Observable<string>; 
  successMessage: ko.Observable<string>;
  errorMessage: ko.Observable<string>;

  constructor() {
    this.name = ko.observable("");
    this.email = ko.observable("");
    this.mobileno = ko.observable("");
    this.address = ko.observable("");
    this.state = ko.observable("");
    this.country = ko.observable("");
    this.username = ko.observable("");
    this.password = ko.observable("");
    this.successMessage = ko.observable("");
    this.errorMessage = ko.observable("");
  }
  connected(): void {
    AccUtils.announce("Incidents page loaded.");
    document.title = "Incidents";
    // implement further logic if needed
  }
  register = async (event: Event) => {
    console.log(JSON.stringify({
        customerName: this.name(),
        customer_email: this.email(),
        customerPhone: this.mobileno(),
        customerAddress: this.address(),
        customerState: this.state(),
        customerCountry: this.country(),
        customerLoginId: this.username(),
        customerPassword: this.password(),
      }))
    const response = await fetch("http://localhost:8080/BankingApp/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        customerName: this.name(),
        customer_email: this.email(),
        customerPhone: this.mobileno(),
        customerAddress: this.address(),
        customerState: this.state(),
        customerCountry: this.country(),
        customerLoginId: this.username(),
        customerPassword: this.password(),
      }),
    });

    if (response.ok) {
      const user = await response.text();
      console.log("Registration successful:", user);
      this.successMessage("Registration successful");
      this.errorMessage("");
      window.location.href="http://localhost:8000/?ojr=dashboard"
    } else {
      console.error("Registration failed");
      this.successMessage("");
      this.errorMessage("Registration failed");
    }
  };
}

export = IncidentsViewModel;
