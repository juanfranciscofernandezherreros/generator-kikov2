'use strict';
const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');

module.exports = class extends Generator {
  prompting() {
    // Have Yeoman greet the user.
    this.log(
      yosay(
        `Welcome to the astonishing ${chalk.red('generator-kikov-2')} generator!`
      )
    );
	
	const tableNamePrompt = [{
    type: 'input',
    name: 'name',
    message: 'The Table Name?'
  },
  ];

  const columnPrompts = [{
    type: 'input',
    name: 'attributeName',
    message: 'Define your Schema - ColumnName?',
    default: 'ID'
  }, {
    type: 'input',
    name: 'attributeType',
    message: 'Define your Schema - DataType?',
    default: 'S'
  }, {
    type: 'confirm',
    name: 'repeat',
    message: 'Do you want to add more columns?',
    default: 'Y'
  }]

  this.columns = [];

  const loop = (relevantPrompts) => {
    return this.prompt(relevantPrompts).then(props => {
      this.columns.push(props);

      return props.repeat ? loop(columnPrompts) : this.prompt([]);

    })
  }
  return loop([...tableNamePrompt, ...columnPrompts]);
  
  }
  //Writings
  writing() {
  this.fs.copyTpl(
    this.templatePath('Schema.json'),
    this.destinationPath('./Schema.json'),
    {
      columns: this.columns
    }
  );
  this.fs.copyTpl(
    this.templatePath('ModelDAO.java'),
    this.destinationPath('ModelDAO.java'),
    {
      columns: this.columns
    }
  );
}

  install() {
    this.installDependencies();
  }
};
