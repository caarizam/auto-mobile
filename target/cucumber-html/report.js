$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/AddToDoNote.feature");
formatter.feature({
  "name": "Add singles notes",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Add basic ToDo Note",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@add-note"
    }
  ]
});
formatter.step({
  "name": "the access to the application",
  "keyword": "Given "
});
formatter.step({
  "name": "a user add the note with title \"\u003cname\u003e\" and reminder switch to \"\u003cflagReminder\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "the user \"can\" see that \"\u003cname\u003e\" with reminder set to \"\u003cflagReminder\u003e\" in the home page list",
  "keyword": "Then "
});
formatter.examples({
  "name": "Data of notes to add",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "flagReminder"
      ]
    },
    {
      "cells": [
        "Basic note",
        "false"
      ]
    },
    {
      "cells": [
        "Note with date and time",
        "true"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Add basic ToDo Note",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@add-note"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the access to the application",
  "keyword": "Given "
});
formatter.match({
  "location": "AddNotesSteps.theAccessToTheApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user add the note with title \"Basic note\" and reminder switch to \"false\"",
  "keyword": "When "
});
formatter.match({
  "location": "AddNotesSteps.aUserAddTheNoteWithAndSwitch(String,boolean)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user \"can\" see that \"Basic note\" with reminder set to \"false\" in the home page list",
  "keyword": "Then "
});
formatter.match({
  "location": "AddNotesSteps.theUserCanSeeThatWithReminderSetToInTheHomePageList(String,String,boolean)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Add basic ToDo Note",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@add-note"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the access to the application",
  "keyword": "Given "
});
formatter.match({
  "location": "AddNotesSteps.theAccessToTheApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user add the note with title \"Note with date and time\" and reminder switch to \"true\"",
  "keyword": "When "
});
formatter.match({
  "location": "AddNotesSteps.aUserAddTheNoteWithAndSwitch(String,boolean)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user \"can\" see that \"Note with date and time\" with reminder set to \"true\" in the home page list",
  "keyword": "Then "
});
formatter.match({
  "location": "AddNotesSteps.theUserCanSeeThatWithReminderSetToInTheHomePageList(String,String,boolean)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Remove a ToDo Note added",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@add-remove-note"
    }
  ]
});
formatter.step({
  "name": "the access to the application",
  "keyword": "Given "
});
formatter.step({
  "name": "a user add the note with title \"\u003cname\u003e\" and reminder switch to \"\u003cflagReminder\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "the user \"can\" see that \"\u003cname\u003e\" with reminder set to \"\u003cflagReminder\u003e\" in the home page list",
  "keyword": "And "
});
formatter.step({
  "name": "the user search and delete the note with name \"\u003cname\u003e\" and reminder switch to \"\u003cflagReminder\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "the user \"cannot\" see that \"\u003cname\u003e\" with reminder set to \"\u003cflagReminder\u003e\" in the home page list",
  "keyword": "Then "
});
formatter.examples({
  "name": "data to add and remove",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "flagReminder"
      ]
    },
    {
      "cells": [
        "Reminder - go to the Gym",
        "true"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Remove a ToDo Note added",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@add-remove-note"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the access to the application",
  "keyword": "Given "
});
formatter.match({
  "location": "AddNotesSteps.theAccessToTheApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user add the note with title \"Reminder - go to the Gym\" and reminder switch to \"true\"",
  "keyword": "When "
});
formatter.match({
  "location": "AddNotesSteps.aUserAddTheNoteWithAndSwitch(String,boolean)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user \"can\" see that \"Reminder - go to the Gym\" with reminder set to \"true\" in the home page list",
  "keyword": "And "
});
formatter.match({
  "location": "AddNotesSteps.theUserCanSeeThatWithReminderSetToInTheHomePageList(String,String,boolean)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user search and delete the note with name \"Reminder - go to the Gym\" and reminder switch to \"true\"",
  "keyword": "And "
});
formatter.match({
  "location": "RemoveSteps.theUserSearchAndDeleteTheNoteWithNameAndReminderSwitchTo(String,boolean)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user \"cannot\" see that \"Reminder - go to the Gym\" with reminder set to \"true\" in the home page list",
  "keyword": "Then "
});
formatter.match({
  "location": "AddNotesSteps.theUserCanSeeThatWithReminderSetToInTheHomePageList(String,String,boolean)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});