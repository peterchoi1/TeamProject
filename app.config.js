appMod.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'views/home.view.html'

		}).when('/student', {
			templateUrl: 'views/student.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/student/:studentId', {
			templateUrl: 'views/detail.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/addstudent/', {
			templateUrl: 'views/addstudent.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/about', {
			templateUrl: 'views/about.view.html'

		}).when('/major', {
			templateUrl: 'views/major.view.html'

		})
		.otherwise({redirectTo: '/'});

	}]) // end config

;
