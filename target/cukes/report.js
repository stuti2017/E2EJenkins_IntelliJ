$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("manageServiceType.feature");
formatter.feature({
  "line": 1,
  "name": "Verify the MRH application web page title",
  "description": "",
  "id": "verify-the-mrh-application-web-page-title",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9326847433,
  "status": "passed"
});
formatter.before({
  "duration": 63997,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify the MRH application web page title",
  "description": "",
  "id": "verify-the-mrh-application-web-page-title;verify-the-mrh-application-web-page-title",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@automated"
    },
    {
      "line": 3,
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I launch the MRH application welcome page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I navigated to Manage Service Types page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I get the all service list",
  "rows": [
    {
      "cells": [
        "DERMATOLOGY"
      ],
      "line": 8
    },
    {
      "cells": [
        "DERMATOLOGY_NEW_PATIENT"
      ],
      "line": 9
    },
    {
      "cells": [
        "GENERAL_MEDICINE"
      ],
      "line": 10
    },
    {
      "cells": [
        "GENERAL_MEDICINE_NEW_PATIENT"
      ],
      "line": 11
    },
    {
      "cells": [
        "GYNECOLOGY"
      ],
      "line": 12
    },
    {
      "cells": [
        "GYNECOLOGY_NEW_PATIENT"
      ],
      "line": 13
    },
    {
      "cells": [
        "INFECTIOUS_DISEASE"
      ],
      "line": 14
    },
    {
      "cells": [
        "INFECTIOUS_DISEASE_NEW_PATIENT"
      ],
      "line": 15
    },
    {
      "cells": [
        "MENTAL_HEALTH"
      ],
      "line": 16
    },
    {
      "cells": [
        "MENTAL_HEALTH_NEW_PATIENT"
      ],
      "line": 17
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MRSHomePageSteps.iLaunchTheMRHApplicationWelcomePage()"
});
formatter.result({
  "duration": 3199421097,
  "status": "passed"
});
formatter.match({
  "location": "MRSHomePageSteps.iNavigatedToManageServiceTypesPage()"
});
