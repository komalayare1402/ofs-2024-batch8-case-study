/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
// import * as Bootstrap from "ojs/ojbootstrap";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import "oj-c/input-password";
import "oj-c/form-layout";
import 'ojs/ojdatetimepicker';
import { ojDatePicker } from 'ojs/ojdatetimepicker';
import 'oj-c/button';
import 'oj-c/message-toast';
import { ojMessage } from 'ojs/ojmessage';
import 'ojs/ojmessages';
import ArrayDataProvider = require("ojs/ojarraydataprovider");
import * as Bootstrap from 'ojs/ojbootstrap';
import "ojs/ojprogress-bar";

class DashboardViewModel {

  value: ko.Observable<string>;
  firstname: ko.Observable<string> | ko.Observable<any>;
  lastname: ko.Observable<string> | ko.Observable<any>;
  salary: ko.Observable<string> | ko.Observable<any>;
  password: ko.Observable<string> | ko.Observable<any>;

  messages: ojMessage.Message[];
  messagesDataprovider: ArrayDataProvider<null, ojMessage.Message>;

  readonly progressValue = ko.observable(20);
  readonly indeterminate = ko.observableArray();
  
    constructor() {
      this.value = ko.observable("Green");
      //initialization
      this.firstname = ko.observable(null);
      this.lastname = ko.observable(null);
      this.salary = ko.observable(null);
      this.password = ko.observable(null);


      const isoTimeYesterday = new Date(Date.now() - 24 * 60 * 60 * 1000).toISOString();
      this.messages = [
        {severity: 'confirmation',
          summary: 'Confirmation message summary no detail',
          timestamp: isoTimeYesterday
        }
      ];this.messagesDataprovider = new ArrayDataProvider(this.messages);
    }

  // constructor() {

  // }

  /**
   * Optional ViewModel method invoked after the View is inserted into the
   * document DOM.  The application can put logic that requires the DOM being
   * attached here.
   * This method might be called multiple times - after the View is created
   * and inserted into the DOM and after the View is reconnected
   * after being disconnected.
   */
  // connected(): void {
  //   AccUtils.announce("Dashboard page loaded.");
  //   document.title = "Dashboard";
  //   // implement further logic if needed
  // }

  /**
   * Optional ViewModel method invoked after the View is disconnected from the DOM.
   */
  // disconnected(): void {
  //   // implement if needed
  // }

  /**
   * Optional ViewModel method invoked after transition to the new View is complete.
   * That includes any possible animation between the old and the new View.
   */
  // transitionCompleted(): void {
  //   // implement if needed
  // }
}

Bootstrap.whenDocumentReady().then(() => {
  ko.applyBindings(new DashboardViewModel(), document.getElementById('formLayoutOptions'));
});

export = DashboardViewModel;
