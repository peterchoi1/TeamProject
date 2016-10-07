var app = angular.module("AppMod", ["ngRoute"])

	app.controller("AppCtrl", ['$http', '$routeParams', '$scope', function($http, $routeParams, $scope) {
		var self = this;
		//console.log($routeParams);
		self.id = $routeParams.studentId;
		self.fn = $routeParams.studentFn;
		self.ln = $routeParams.studentLn;
		self.sat = $routeParams.studentSat;
		self.gpa = $routeParams.studentGpa;

		$http.get('http://localhost:8080/majors')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});


	}]); // end controller



	app.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'views/home.view.html'

		}).when('/major', {
			templateUrl: 'views/major.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/student/:studentId', {
			templateUrl: 'views/detail.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/about', {
			templateUrl: 'views/about.view.html'

		}).when('/student/update/:studentId/:studentFn/:studentLn/:studentSat/:studentGpa', {
			templateUrl: 'views/submitted.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/student/edit/:studentId', {
			templateUrl: 'views/edit.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'
		})

		.otherwise({redirectTo: '/'});

	}]); // end config
