import Component from '@glimmer/component';

export default class EmployeesFilterComponent extends Component {
  get results() {
    let { employees, query } = this.args;

    if (query) {
      employees = employees.filter(employee => employee.name.includes(query));
    }

    return employees;
  }
}
