import { Component, OnDestroy, OnInit } from '@angular/core';
import * as Leaflet from 'leaflet';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit, OnDestroy {

  title = 'leafletApps';
  map: Leaflet.Map;

  constructor() { }

  ngOnInit(): void {

    this.map = Leaflet.map('map')
                      .setView([18.476389, -69.893333], 7);

    Leaflet.tileLayer(
      'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'DAGTECH © 2021',
      }).addTo(this.map);

    Leaflet.marker([18.5, -69.983333])
           .addTo(this.map).bindPopup('Distrito Nacional')
           .openPopup();
    Leaflet.marker([19.45, -70.7])
           .addTo(this.map).bindPopup('Santiago').openPopup();
    
  }

  ngOnDestroy(): void {
    this.map.remove();
  }


}
