import { TestBed } from '@angular/core/testing';

import { SavingDataService } from './saving-data.service';

describe('SavingDataService', () => {
  let service: SavingDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SavingDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
