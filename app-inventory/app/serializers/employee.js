import DS from 'ember-data';

export default DS.JSONSerializer.extend(DS.EmbeddedRecordsMixin, {
  attrs: {
    devices: {
      serialize: 'records',
      deserialize: 'records'
    }
  }
});
